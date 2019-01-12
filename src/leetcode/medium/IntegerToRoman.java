package leetcode.medium;

public class IntegerToRoman {
    int [] nums = new int[]{
            1000,900,500,400,100,90,50,40,10,9,8,7,6,5,4,3,2,1
    };
    String [] roms = new String[]{
            "M","CM","D","CD","C","XC","L","XL","X","IX","VIII","VII","VI","V","IV","III","II","I"
    };

    public String intToRoman(int num) {
        if(num <=0 ){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            for(int i=0;i<nums.length;i++){
                if(num >= nums[i]){
                    num -= nums[i];
                    sb.append(roms[i]);
                    break;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman ir = new IntegerToRoman();
        System.out.println(ir.intToRoman(3));
        System.out.println(ir.intToRoman(4));
        System.out.println(ir.intToRoman(1994));
        System.out.println(ir.intToRoman(58));
    }
}
