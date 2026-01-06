package JAVA.SHASHCODE.LECTURE142;

public class Adding_spaces_to_a_string {
    // // method 1:
    // public String addSpaces(String s, int[] spaces) {
    //     StringBuilder sb=new StringBuilder(s);
    //     int spaceCounter=0;
    //     for(int spaceIndex:spaces){
    //         sb.insert(spaceIndex+spaceCounter," ");
    //         spaceCounter++;
    //     }
    //     return sb.toString();
    // }

    // // method 2 2 pointer approach
    public String addSpaces(String s, int[] spaces){
        int n=s.length();
        int m=spaces.length;
        StringBuilder sb=new StringBuilder(n+m);
        int spaceIndex=0;
        for(int stringIndex=0;stringIndex<n;stringIndex++){
            if(spaceIndex<m && spaces[spaceIndex]==stringIndex){
                sb.append(" ");
                spaceIndex++;
            }
            sb.append(s.charAt(stringIndex));
        }
        return sb.toString();
    }
}
