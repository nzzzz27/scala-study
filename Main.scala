object Main extends App { 
    // println("Hello Scala") //文字列をコンソールに出力

    //階乗を求める
    def sum(n: Int): Int = {
        println(n, '1')
        if (n == 0) {
            return 1
        }
        sum(n - 1) * n
    }
    println(sum(2), "-----")

}


// object Main
// Mainというオブジェクトを宣言

// extends App
// Mainという名前のアプリケーションを作成

// ↓
// Main というオブジェクトが、 App というトレイトをミックスインしていることを宣言している