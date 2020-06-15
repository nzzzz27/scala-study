object PartialSumDFS extends App {

    val a = Seq(3, 6, -5, 7)
    val n = a.length
    val k = 8

    //isMatchAndResult（数列を走査する際の添字, 整数のシーケンス）: (マッチしたかの真偽値, 結果の整数のシーケンス)
    //マッチ = 選びとった整数の合計値と指定された合計値が一緒になること
    def isMatchAndResult(index: Int, partial: Seq[Int]): (Boolean, Seq[Int]) = {

        //ループの終了条件
        if (index == n) {
            //(aから選ばれた整数を足し合わせ、kと=だったら) (true, 整数のシーケンス) else (false, 空のシーケンス)
            //.sum：全要素の和を求める
            return if (partial.sum == k) (true, partial) else (false, Seq())
        }

        // ↓再帰呼び出しの最後に到達していない場合 

        //現在の添字の数列を結果に加えない、returnで強制終了
        val (isMatchNotAdd, resultNotAdd) = isMatchAndResult(index + 1, partial)
        if (isMatchNotAdd) return (isMatchNotAdd, resultNotAdd)

        //現在の添字の数列を結果に加える
        isMatchAndResult(index + 1, partial :+ a(index))

    }

    val (isMatch, result) = isMatchAndResult(0, Seq())
    if (isMatch) println(s"Yes ${result}") else println("No")
}