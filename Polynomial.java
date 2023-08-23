import java.util.Scanner;
public class Polynomial {

   int[] poly=new int[10000];;
  
      


public void setCoefficient(int degree, int coeff){
   if(degree>poly.length-1){
       int[] temp = poly;
       poly = new int[2*poly.length];
       for(int i =0;i<temp.length;i++){
           poly[i]=temp[i];
       }
   }
    poly[degree] = coeff;
}

// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
public void print(){
    for(int i=0;i<poly.length;i++){
        if(poly[i]!=0)
        System.out.print(poly[i]+"x"+i+" ");
    }
}


// Adds two polynomials and returns a new polynomial which has result
public Polynomial add(Polynomial p){
Polynomial p1 = new Polynomial();
int poly1 = this.poly.length;
int poly2 = p.poly.length;
int len = Math.min(poly1,poly2);
 int i=0;
for( i=0;i<len;i++){
    p1.setCoefficient(i,this.poly[i]+p.poly[i]);
}
if(i<poly1){
    p1.setCoefficient(i,this.poly[i]);
}
if(i<poly2){
    p1.setCoefficient(i,p.poly[i]);
}

    return p1;
}

// Subtracts two polynomials and returns a new polynomial which has result
public Polynomial subtract(Polynomial p){
         Polynomial p1 = new Polynomial();
int poly1 = this.poly.length;
int poly2 = p.poly.length;
int len = Math.min(poly1,poly2);
int i=0;
for( i=0;i<len;i++){
    p1.setCoefficient(i,this.poly[i]-p.poly[i]);
}
if(i<poly1){
    p1.setCoefficient(i,this.poly[i]);
}
if(i<poly2){
    p1.setCoefficient(i,p.poly[i]);
}

    return p1;
}

// Multiply two polynomials and returns a new polynomial which has result
public Polynomial multiply(Polynomial p){
         Polynomial p1 = new Polynomial();
int poly1 = this.poly.length;
int poly2 = p.poly.length;
int i=0;
for( i=0;i<poly1;i++){
    for(int j=0;j<poly2;j++){
        if((this.poly[i]!=0) && (p.poly[j]!=0))
        p1.setCoefficient(i+j , this.poly[i]*p.poly[j]);
    }
}
return p1;
}
public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    System.out.print("Enter the no of coff::");
    int n = s.nextInt();
    int degree1[] = new int[n];
    for(int i = 0; i < n; i++){
        degree1[i] = s.nextInt();
    }
    int coeff1[] = new int[n];
    for(int i = 0; i < n; i++){
        coeff1[i] = s.nextInt();
    }
    Polynomial first = new Polynomial();
    for(int i = 0; i < n; i++){
        first.setCoefficient(degree1[i],coeff1[i]);
    }
    n = s.nextInt();
    int degree2[] = new int[n];
    for(int i = 0; i < n; i++){
        degree2[i] = s.nextInt();
    }
     int coeff2[] = new int[n];
    for(int i = 0; i < n; i++){
        coeff2[i] = s.nextInt();
    }
    Polynomial second = new Polynomial();
    for(int i = 0; i < n; i++){
        second.setCoefficient(degree2[i],coeff2[i]);
    }
    int choice = s.nextInt();
    Polynomial result;
    switch(choice){
    // Add
    case 1: 
         result = first.add(second);
        result.print();
        break;
    // Subtract	
    case 2 :
         result = first.subtract(second);
        result.print();
        break;
    // Multiply
    case 3 :
         result = first.multiply(second);
        result.print();
        break;
    }

}
}