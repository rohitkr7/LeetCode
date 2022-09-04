class Solution {
    public boolean isValid(String s) {
        Stack st = new Stack<Character>();
        
        HashMap hm = new HashMap<Character, Character>();
        hm.put('(', ')');
        hm.put('{','}');
        hm.put('[',']');
        
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }else if(! st.isEmpty()) {
                char top = (char)st.peek();
                if(c == (char)hm.get(top)){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        
        
        return st.size() == 0;
    }
}