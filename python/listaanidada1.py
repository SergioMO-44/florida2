cubo = [[[] for _ in range(5)] for _ in range(5)]
print(cubo)
for i in range(len(cubo)):
	for j in range(len(cubo)):
		cubo[i][j] = list(range(len(cubo)))
print(cubo)