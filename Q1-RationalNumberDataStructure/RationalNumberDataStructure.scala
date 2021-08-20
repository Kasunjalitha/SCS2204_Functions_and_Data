//Q1
//index number: 19000642


object RationalNumberDataStructure extends App{

	class Rational(val numer:Int, val denom:Int){

		def neg = new Rational(-this.numer, denom); 

		override def toString = numer + "/" + denom;	
	}


	val x = new Rational(3, 4);

	println(x.toString);

	val negX = x.neg;

	println(negX.toString);

	
}