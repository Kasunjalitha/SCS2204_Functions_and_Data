//Q2
//index number: 19000642


object RationalNumber extends App{
	
	def findGCD(a:Int, b:Int):Int = {
		if (b == 0) return a;
    	return findGCD(b, a % b);
	}

	def findLCM(a:Int, b:Int):Int = {
		return (a/findGCD(a, b))*b;
	}

	class Rational(val numer:Int, val denom:Int){

		def +(r:Rational):Rational = {
			val newDenom = findLCM(denom, r.denom);
			new Rational(((newDenom/denom)*numer) + ((newDenom/r.denom)*r.numer), newDenom);
		}

		def -(r:Rational):Rational = this + r.neg;

		def neg = new Rational(-this.numer, denom); 

		override def toString = numer + "/" + denom;
		
	}

	val x1 = new Rational(3, 4);

	val x2 = new Rational(5, 8);

	val x3 = new Rational(2, 7);


	val y = x1-x2-x3;
	val s = y.toString;
	println(s);
}