## Asteroid Collision – Stack Approach

### 1. Create a Stack
- Initialize a stack to store asteroids that are still moving and have not been destroyed.

### 2. Traverse the Asteroid Array
- Iterate through the asteroid array one by one.
- Let the current asteroid be `a`.

### 3. Check If a Collision Is Possible
A collision can occur **only if**:
- The stack is not empty  
- `stack.peek() > 0` (asteroid in stack is moving right)  
- `a < 0` (current asteroid is moving left)

### 4. Resolve Collisions (Using a Loop)
While the collision condition holds:

- **If** `|a| > |stack.peek()|`  
  → The asteroid in the stack explodes  
  → Pop it from the stack and continue checking

- **If** `|a| == |stack.peek()|`  
  → Both asteroids explode  
  → Pop the stack asteroid and stop processing the current one

- **If** `|a| < |stack.peek()|`  
  → The current asteroid explodes  
  → Stop processing the current one

### 5. Push the Current Asteroid
- If the current asteroid was **not destroyed**, push it into the stack.

### 6. After Traversal
- All remaining asteroids in the stack represent the final state after all collisions.

### 7. Convert Stack to Array
- Pop elements from the stack and store them in an array in **reverse order** to get the correct result.
