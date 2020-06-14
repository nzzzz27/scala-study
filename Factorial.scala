// 任意精度整数の型を読み込み。
// 通常Intは32bitの整数（-2147483648 〜　2147483648）のみしか表現できないため、BigInt という Int の上限を超えて、コンピューターのリソースが許すかぎりの 大きな整数を表すことができる型である BigInt を利用します。
import scala.math.BigInt

object Factorial extends App {

    def factorial(i: BigInt): BigInt = if (i == 0) 1 else i * factorial(i -1)

    println(factorial(3))
}


/*
def
関数宣言

(i: BigInt)
BigInt型で引数を渡す

def factorial(i: BigInt): BigInt
関数の戻り値がBigInt型であることを指定
*/


//練習問題

object PriceOfComputer extends App {

    val computerPrice = 129512
    val tax = 1.08
    
    println((computerPrice * tax).toInt)
}

object FactorialPractice3 extends App {

    def factorial(n: BigInt, acc: BigInt): BigInt = {
        if (n == 0) {
             return acc
        }
        factorial(n - 1, n * acc)
    }

    println(factorial(10000, 1))
}

/*
メモ：末尾再帰最適化の仕組み

factorial(3, 1)の時、

n = 3, acc = 1
factorial(3 - 1, 3 * 1)
↓
n = 2, acc = 3
factorial(2 - 1, 2 * 3)
↓
n = 1, acc = 6
factorial(1 - 1, 1 * 6)
↓
n = 0, acc = 6
return acc // = 6
*/