//Q4
//index number: 19000642



object Bank extends App{

	class Account(x:String, y:Int, z:Double){
	var NIC:String = x;
	var accountNumber:Int = y;
	var balance:Double = z;

	
	def withdraw(ammount:Double) = if(this.balance>=ammount) this.balance = this.balance - ammount;

	def deposit(ammount:Double) = this.balance = this.balance + ammount;

	def transfer(ammount:Double, that:Account) = {

		if(this.balance>=ammount){
			this.balance = this.balance - ammount;
			that.balance = that.balance + ammount;
		}
	}

	@Override
	override def toString():String = "NIC: " + this.NIC + "\nAcc.No: " + this.accountNumber + "\nBalance: " + this.balance;
	}


	val acc1 = new Account("982323102v", 1006480, 5000.00);
	val acc2 = new Account("962343122v", 2007380, 15000.00);
	val acc3 = new Account("993623702v", 1040080, 2000.00);
	val acc4 = new Account("963622702v", 1023080, -2000.00);
	val acc5 = new Account("963622702v", 1906080, -1000.00);


	var bank:List[Account] = List(acc1, acc2, acc3, acc4, acc5);

	val negativeBalance = bank.filter(x=>x.balance<0);
	val sumofbalance = bank.map((x)=>(x.balance)).reduce((x,y)=>(x+y));
	// val interest = (b:List[Account])=>b.map((x) => (x.NIC,x.accountNumber,if(x.balance>0)  (x.balance+(x.balance*0.5)) else (x.balance+(x.balance*0.1)) ));

	val interest = ( b : List[Account] ) => b.map( x => {
        x.balance match {
            case a if a >= 0 => x deposit x.balance * 0.05
            case _ => x withdraw Math.abs(x.balance) * 0.01

        }
        x
    })

	// println(negativeBalance);

	println("Accounts with negative balances\n\n");
	for(element<-negativeBalance){ 
        println(element + "\n"); 
    } 

    println("\n--------------------------------\n")

	println("Sum of all account balances: " + sumofbalance + "\n\n--------------------------------\n\n");


	println("Final balances of all accounts after apply the interest\n\n");
	for(element<-interest(bank)){ 
        println(element + "\n"); 
    } 
}