Key Insight

Characters (a–z) can be modeled as nodes in a graph

Each conversion rule is a directed edge with weight = cost

Converting a character may require multiple intermediate steps

We need the shortest path cost between every pair of characters

Approach (High Level)

Graph Representation

Nodes: 26 lowercase letters

Directed edges: original → changed with given cost

If multiple rules exist for the same conversion, keep the minimum cost

All-Pairs Shortest Path

Compute the minimum cost to convert any letter to any other letter

Allows indirect transformations (e.g., a → c → b)

Use a fixed-size solution since alphabet size is constant

Final Cost Calculation

Traverse the strings index by index

For each position:

If source[i] == target[i] → cost 0

Else:

If no path exists → return -1

Otherwise, add the minimum conversion cost

Sum all character conversion costs

Key Points to Remember

Transformations are directional

Multiple operations are allowed

Indirect conversions can be cheaper than direct ones

Alphabet size is small → efficient global shortest-path solution

If any character cannot be converted → answer is -1
