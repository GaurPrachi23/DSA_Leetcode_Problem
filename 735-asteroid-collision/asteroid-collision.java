class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int a : asteroids){
            boolean alive = true;
        while(alive && !stack.isEmpty() && stack.peek() > 0 && a < 0){
            if(Math.abs(stack.peek()) < Math.abs(a)){
                stack.pop();
            }else if(Math.abs(stack.peek()) == Math.abs(a)){
                stack.pop();
                alive = false;
            }else{
                alive = false;
            }
        }
            if(alive){
                stack.push(a);
            }
        }
        int [] res = new int[stack.size()];
        for(int i = stack.size() - 1; i>=0; i-- ){
            res[i] = stack.pop();
        }
        return res;
    }
}