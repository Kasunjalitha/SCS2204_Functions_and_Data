//Q3
//index number: 19000642


object Account extends App{
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

	acc1.deposit(1000.00);
	acc1.withdraw(5000.00);
	acc1.transfer(2000, acc2);

	println(acc1);
	println("\n")
	println(acc2);
}

