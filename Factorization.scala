import scala.math.sqrt

object Factorization extends App {

    val target = 24
    val maxDivisor = sqrt(target).toInt

    def factorizationRec(num: Int, divisor: Int, acc: Map[Int, Int]): Map[Int, Int] = {

        //「割る数 divisor」が「割る数 maxDivisor」の最大値より大きくなったら、現在までの結果に今の「割られる数 num」を足して答えとする
        //ただし、「割られる数」num が 1 の場合は、1 は約数にならないので足さず、そのままの結果を返す
        if (divisor > maxDivisor) {
            if (num == 1) acc else acc + (num -> 1)

        //「割る数 divisor」で「割られる数 num」を割り切れた時
        } else if (num % divisor == 0) {
            //「現在の結果 acc」に「現在の結果 acc」のキーの答えが、現在より１多くなるような値を作成
            val nextAcc = acc + (divisor -> (acc.getOrElse(divisor, 0) + 1))
            
            factorizationRec(num / divisor, divisor, nextAcc)

        } else {
            factorizationRec(num, divisor + 1, acc)
        }
    }

    println(factorizationRec(target, 2, Map()))
}


// 平方根を求める関数を利用できるようにする
// import scala.math.sqrt