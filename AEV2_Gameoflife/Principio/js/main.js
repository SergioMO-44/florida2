const canvas = document.getElementById("life");
const ctx = canvas.getContext("2d");
const CELL_SIZE = 8;
const COLS = Math.floor(canvas.width / CELL_SIZE);
const ROWS = Math.floor(canvas.height / CELL_SIZE);
// Crea una cuadrícula vacía (0 = muerta, 1 = viva)
function createGrid(rows, cols, fill = false) {
  const g = new Array(rows);
  for (let r = 0; r < rows; r++) {
    g[r] = new Array(cols).fill(fill ? 1 : 0);
  }
  return g;
}
let grid = createGrid(ROWS, COLS, false);
function randomize(p = 0.2) {
  for (let r = 0; r < ROWS; r++) {
    for (let c = 0; c < COLS; c++) {
      grid[r][c] = Math.random() < p ? 1 : 0;
    }
  }
}
randomize(0.2); // 20% vivas
//console.log(grid);
  function draw(showGrid = true) {
 ctx.clearRect(0, 0, canvas.width, canvas.height);
 // Celdas vivas
 for (let r = 0; r < ROWS; r++) {
   for (let c = 0; c < COLS; c++) {
     if (grid[r][c]) {
       ctx.fillRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
      }
    }
   }
    // Rejilla opcional
 /*if (showGrid) {
   ctx.beginPath();
   for (let x = 0; x <= COLS; x++) {
     ctx.moveTo(x * CELL_SIZE, 0);
     ctx.lineTo(x * CELL_SIZE, ROWS * CELL_SIZE);
   }
   for (let y = 0; y <= ROWS; y++) {
     ctx.moveTo(0, y * CELL_SIZE);
     ctx.lineTo(COLS * CELL_SIZE, y * CELL_SIZE);
    }
   ctx.stroke();
  }*/
}
draw();
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
/*// Insertar un blinker (oscilador) en el centro
 function setBlinker(r, c) {
 grid[r][c-1] = 1;
 grid[r][c] = 1;
 grid[r][c+1] = 1; 
}
setBlinker(Math.floor(ROWS/2), Math.floor(COLS/2));
draw();
 // Oscillator: Toad (6 celdas)
function setToad(r, c) {
 grid[r][c-1] = 1;
 grid[r][c] = 1;
 grid[r][c+1] = 1;
 grid[r-1][c] = 1;
 grid[r-1][c+1] = 1;
 grid[r-1][c+2] = 1;
}
  // Oscillator: Beacon (2 bloques que alternan)
function setBeacon(r, c) {
 // bloque superior izquierdo
 grid[r][c] = 1;
 grid[r][c+1] = 1; 
 grid[r-1][c] = 1;
 grid[r-1][c+1] = 1;
 // bloque inferior derecho
 grid[r-2][c-2] = 1;
 grid[r-2][c-3] = 1;
 grid[r-3][c-2] = 1;
 grid[r-3][c-3] = 1;
}
 // Insertar un glider en el centro
 function setGlider(r, c) {
 grid[r][c] = 1;
 grid[r][c+1] = 1;
 grid[r][c+2] = 1;
 grid[r-1][c+2] = 1;
 grid[r-2][c+1] = 1;
 }
 setGlider(Math.floor(ROWS/2), Math.floor(COLS/2));
 draw();
*/
function step() {
  const next = createGrid(ROWS, COLS, false);
  for (let r = 0; r < ROWS; r++) {
    for (let c = 0; c < COLS; c++) {
      const alive = grid[r][c] === 1;
      const n = neighbors(r, c);
      next[r][c] = (alive && (n === 2 || n === 3)) || (!alive && n === 3) 
     ? 1 : 0;
    }
 }
 grid = next;
 draw();
}
step(); // prueba una generación
let running = true;
function loop() {
  if (running) {
    step();
  }
  requestAnimationFrame(loop);
}
loop();
// (Espacio) para pausar/reanudar
document.addEventListener("keydown", (e) => {
  if (e.key === " ") {
    running = !running;
    e.preventDefault();
  }
});
function clearAll() {
 grid = createGrid(ROWS, COLS, false);
 draw();
 }
 function randomFill(p = 0.20) {
 randomize(p);
 draw();
 }
 // Ejemplo HTML adicional:
 // <button onclick="clearAll()">Limpiar</button>
 // <button onclick="randomFill(0.20)">Aleatorio</button>
console.log(grid);