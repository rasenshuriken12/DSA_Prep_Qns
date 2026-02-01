Perspective 1: Think of digits as a graph
Each digit (0–9) is a node. From digit d, you can go to:

d + k  d − k
(if they’re within [0..9])

Example for k = 1:

1 → {0, 2}
2 → {1, 3}
3 → {2, 4}
...
8 → {7, 9}
9 → {8, 0}

Now the problem becomes:
Generate all paths of length n in this graph, starting from digits 1..9.

Perspective 2: Why no leading zero matters
We never start from 0.
Start nodes:

1, 2, 3, 4, 5, 6, 7, 8, 9
But later digits can be zero.
This is why 070 is invalid but 707 is valid.
