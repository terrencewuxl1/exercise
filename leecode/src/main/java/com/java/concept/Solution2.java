package com.java.concept;

class Solution2 {
    String[] arr1={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine",
            "Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen",
            "Seventeen","Eighteen","Nineteen"};
    String[] arr2={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] arr3={"Hundred","Thousand","Million","Billion"};

    public String numberToWords(int num) {
        if(num==0)return "Zero";
        StringBuffer sb=new StringBuffer();
        if(num>=1000000000){
            sb.append(oneToMillion(num/1000000000)+" ");
            sb.append(arr3[3]+" ");
            num=num%1000000000;
        }
        if(num>=1000000){
            sb.append(oneToThousand(num/1000000)+" ");
            sb.append(arr3[2]+" ");
            num=num%1000000;
        }
        if(num>=1000){
            sb.append(oneToThousand(num/1000));
            sb.append(" ");
            sb.append(arr3[1]+" ");
            num=num%1000;
        }
        sb.append(oneToThousand(num)+" ");
        return sb.toString().trim();
    }


    String oneToHundred(int num){
        if(num>=20){
            if(num%10==0)return arr2[num/10];
            else
                return arr2[num/10]+" "+arr1[num%10];
        }else
            return arr1[num];
    }

    String oneToThousand(int num){
        if(num>=100){
            if(num%100==0)
                return arr1[num/100]+" "+arr3[0];
            else
                return arr1[num/100]+" "+arr3[0]+" "+oneToHundred(num%100);
        }
        else
            return oneToHundred(num);
    }

    String oneToMillion(int num){
        if(num>=1000){
            if(num%1000==0)
                return arr1[num/1000]+" "+arr3[1];
            else
                return arr1[num/1000]+" "+arr3[1]+" "+oneToThousand(num%1000);
        }
        else
            return oneToThousand(num);
    }
}