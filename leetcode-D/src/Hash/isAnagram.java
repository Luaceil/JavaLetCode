package Hash;

public class isAnagram {
    public boolean isAnagram(String s,String t)
    {
        int N=s.length();
        if(N!=t.length()) return false;

        int[] result=new int[26];
        for(int i=0;i<N;i++)
        {
            int tmp=s.charAt(i)-'a';
            result[tmp]++;
            result[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++)
        {
            if(result[i]!=0)
                return false;
        }

        return true;
    }
}
