const canvas = document.getElementById("life");
const ctx = canvas.getContext("2d");
const CELL_SIZE = 12;
const COLS = Math.floor(canvas.width / CELL_SIZE);
const ROWS = Math.floor(canvas.height / CELL_SIZE);

function createGrid(rows, cols, fill = false) {
  const g = new Array(rows);
  for (let r = 0; r < rows; r++) {
    g[r] = new Array(cols).fill(fill ? 1 : 0);
  }
  return g;
}

let grid = createGrid(ROWS, COLS, false);
let generations = 0;

function draw() {
  ctx.clearRect(0, 0, canvas.width, canvas.height);
  ctx.fillStyle = "limegreen";
  for (let r = 0; r < ROWS; r++) {
    for (let c = 0; c < COLS; c++) {
      if (grid[r][c]) {
        ctx.fillRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
      }
    }
  }
}

function neighbors(r, c) {
  let n = 0;
  for (let dr = -1; dr <= 1; dr++) {
    for (let dc = -1; dc <= 1; dc++) {
      if (dr === 0 && dc === 0) continue;
      const rr = (r + dr + ROWS) % ROWS;
      const cc = (c + dc + COLS) % COLS;
      n += grid[rr][cc];
    }
  }
  return n;
}

function step() {
  const next = createGrid(ROWS, COLS, false);
  for (let r = 0; r < ROWS; r++) {
    for (let c = 0; c < COLS; c++) {
      const alive = grid[r][c] === 1;
      const n = neighbors(r, c);
      next[r][c] = (alive && (n === 2 || n === 3)) || (!alive && n === 3) ? 1 : 0;
    }
  }
  grid = next;
  generations++;
  document.getElementById("info").textContent = `Generación: ${generations}`;
  draw();
}

let running = true;
function loop() {
  if (running) {
    step();
  }
  requestAnimationFrame(loop);
}
loop();

document.addEventListener("keydown", (e) => {
  if (e.key === " ") {
    running = !running;
    console.log(running ? "Simulación en ejecución" : "Simulación pausada");
    e.preventDefault();
  }
});

function resetBtn() {
  grid = createGrid(ROWS, COLS, false);
  generations = 0;
  document.getElementById("info").textContent = `Generación: ${generations}`;
  draw();
}

// 🔷 Funciones individuales para cada patrón
function setBlinker(r, c) {
  if (r >= 0 && r < ROWS && c - 1 >= 0 && c + 1 < COLS) {
    grid[r][c - 1] = 1;
    grid[r][c] = 1;
    grid[r][c + 1] = 1;
  }
}

function setToad(r, c) {
  if (r - 1 >= 0 && r < ROWS && c - 1 >= 0 && c + 2 < COLS) {
    grid[r][c - 1] = 1;
    grid[r][c] = 1;
    grid[r][c + 1] = 1;
    grid[r - 1][c] = 1;
    grid[r - 1][c + 1] = 1;
    grid[r - 1][c + 2] = 1;
  }
}

function setBeacon(r, c) {
  if (r - 3 >= 0 && r < ROWS && c - 3 >= 0 && c + 1 < COLS) {
    grid[r][c] = 1;
    grid[r][c + 1] = 1;
    grid[r - 1][c] = 1;
    grid[r - 1][c + 1] = 1;
    grid[r - 2][c - 2] = 1;
    grid[r - 2][c - 3] = 1;
    grid[r - 3][c - 2] = 1;
    grid[r - 3][c - 3] = 1;
  }
}

function setGlider(r, c) {
  if (r - 2 >= 0 && r < ROWS && c + 2 < COLS) {
    grid[r][c] = 1;
    grid[r][c + 1] = 1;
    grid[r][c + 2] = 1;
    grid[r - 1][c + 2] = 1;
    grid[r - 2][c + 1] = 1;
  }
}

// 🔁 Cargar múltiples instancias del patrón
function loadPattern(name) {
  resetBtn();
  const spacing = 10;
  for (let r = 5; r < ROWS - 5; r += spacing) {
    for (let c = 5; c < COLS - 5; c += spacing) {
      if (name === "blinker") setBlinker(r, c);
      else if (name === "toad") setToad(r, c);
      else if (name === "beacon") setBeacon(r, c);
      else if (name === "glider") setGlider(r, c);
    }
  }
  draw();
}
