📌 Maximal Rectangle in a Binary Matrix — Revision Notes
🔍 Problem Statement

Given a binary matrix consisting of 0s and 1s, find the largest rectangular area that contains only 1s.

🧠 Core Concept

👉 Transform the 2D matrix problem into multiple 1D histogram problems.

Each row is treated as the base of a histogram where bar heights represent continuous vertical 1s.

💡 Key Insight

Any rectangle of 1s must end at some row

Vertical continuity can be accumulated row by row

Horizontal continuity is handled using a stack-based histogram approach

🔄 Step-by-Step Approach
1️⃣ Build Heights (Vertical Accumulation)

For each row:

If the current cell is 1 → increase height

If the current cell is 0 → reset height to 0

This ensures rectangles do not span across zeros.

2️⃣ Treat Each Row as a Histogram

After building heights for a row, it represents a histogram

Now find the largest rectangle in that histogram

3️⃣ Use Monotonic Stack (Histogram Logic)

Maintain a stack of indices with increasing heights

When a smaller height is encountered:

Pop from stack

Calculate area using the popped height

A sentinel (imaginary zero height) ensures all bars are processed

📐 Area Calculation Logic

Height = value at popped index

Width = distance between nearest smaller bars on left and right

Area = height × width

🧪 Example Understanding

Matrix:

0 1
1 0


Histograms:

Row 1 → [0,1] → max area = 1
Row 2 → [1,0] → max area = 1


✅ Final Answer = 1

(Rectangles cannot jump over zeros)

⏱ Time & Space Complexity

Time Complexity: O(rows × cols)

Space Complexity: O(cols)

⚠️ Common Mistakes to Avoid

❌ Allowing rectangles to span over columns with 0
❌ Not resetting heights on encountering 0
❌ Incorrect width calculation in histogram
❌ Forgetting to process remaining bars in stack

🎯 Interview One-Liner

“I convert each row into a histogram of consecutive 1s and compute the largest rectangle using a monotonic stack.”

📌 When This Pattern is Useful

Maximum area / rectangle problems

2D → 1D transformations

Stack-based optimization problems

Dynamic programming + stack combinations

🧠 Memory Trick

Matrix → Heights → Histogram → Stack → Max Area
