# alignment.py: Reads from standard input, the output produced by
# edit_distance.py, i.e., input strings x and y, and the opt matrix. The
# program then recovers an optimal alignment from opt, and writes to
# standard output the edit distance between x and y and the alignment itself.

import stdarray
import stdio

# Read x, y, and opt from standard input.
x=stdio.readString()
y=stdio.readString()
stdio.readInt()
stdio.readInt()

# Compute M and N.
M=len(x)
N=len(y)
opt=stdarray.create2D(M+1,N+1,0)
for i in range(M+1):
    for j in range(N+1):
        opt[i][j]=stdio.readInt()

# Write edit distance between x and y.
edit_distance=opt[0][0]
stdio.writef('Edit distance = %d\n', edit_distance)

# Recover and write an optimal alignment.
i=0
j=0
while i<M or j<N:
    if i==M or j==N:
        if i>j:
            stdio.writef('- %s 2\n', y[j])
        elif j>i:
            stdio.writef('%s - 2\n', x[i])
        break
            
    if opt[i][j]==opt[i+1][j]+2:
        stdio.writef('%s - 2\n', x[i])
        i+=1

    elif opt[i][j]==opt[i][j+1]+2:
        stdio.writef('- %s 2\n', y[j])
        j+=1

    elif x[i]==y[j]:
        stdio.writef('%s %s 0\n', x[i], y[j])
        i+=1
        j+=1
    else:
        stdio.writef('%s %s 1\n', x[i], y[j])
        i+=1
        j+=1


