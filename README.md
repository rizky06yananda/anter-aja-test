1. Jawaban Soal 1
package com.test.rizky;

public class Soal1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++){
            if  (i % 3 == 0){
                System.out.println(i+ " ANTER");
            }
            if  (i % 5 == 0){
                System.out.println(i+" AJA");
            }
        }
    }
}


Output:
3 ANTER
5 AJA
6 ANTER
9 ANTER
10 AJA
12 ANTER
15 ANTER
15 AJA
18 ANTER
20 AJA
21 ANTER
24 ANTER
25 AJA
27 ANTER
30 ANTER
30 AJA
33 ANTER
35 AJA
36 ANTER
39 ANTER
40 AJA
42 ANTER
45 ANTER
45 AJA
48 ANTER
50 AJA

Process finished with exit code 0


2. Jawaban Soal 2 (Palindrome)
Code Input Aku, AJA
package com.test.rizky;


// run INPUT AKU
public class Palindrom {
    public static void main(String[] args){
        new Palindrom().palindrome("AKU");
    }

    private void palindrome(String teks){
        String poli = "";

        for(int i=teks.length();i>0;i--){
            String test1 = teks.substring(i-1, i);
            poli += test1;
        }

        if(teks.equals(poli)){
            System.out.println("==== "+teks+" adalah Palindrome =====");
        }else{
            System.out.println("==== "+teks+" bukan Palindrome =====");
        }
    }
}

// run Input AJA
public class Palindrom {
    public static void main(String[] args){
        new Palindrom().palindrome("AJA");
    }

    private void palindrome(String teks){
        String poli = "";

        for(int i=teks.length();i>0;i--){
            String test1 = teks.substring(i-1, i);
            poli += test1;
        }

        if(teks.equals(poli)){
            System.out.println("==== "+teks+" adalah Palindrome =====");
        }else{
            System.out.println("==== "+teks+" bukan Palindrome =====");
        }
    }
}

Output Bukan Palindrome
==== AKU bukan Palindrome =====

Process finished with exit code 0

Output Palindrome
==== AJA bukan Palindrome =====

Process finished with exit code 0

3. Soal 3

Untuk menjalankan API, lakukan langkah berikut
1. mvn clean install -Dmaven.test.skip=true
2. Vm option yang digunakan local, bisa menambahkan code berikut -Dspring.profiles.active=local
3. jalankan redis dan mysql
4. Untuk Dokumentasi Postman Bisa Akses Link Berikut https://www.getpostman.com/collections/e85250abd1685d0fea16

