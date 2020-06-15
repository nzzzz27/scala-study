object SimpleSearch extends App {
    val text = "カワカドカドカドドワンゴカドカドンゴドワドワンゴドワカワカドンゴドワ".toSeq
    val pattern = "ドワンゴ".toSeq

    //search関数の結果を代入
    val matchIndexes = search(text, pattern)

    //引数：「文書」と「パターン」、戻り値：出現箇所の添字を取得
    def search(text: Seq[Char], pattern: Seq[Char]): Seq[Int] = {

        //空のListを作成
        var matchIndexes = Seq[Int]()
        
        //to：0も含む　until：含まない
        for (i <- 0 to text.length - 1) {
            //slice：第一引数から第二引数までの添字の部分のシーケンスを切り出す
            //iから、i + patternの文字数分を切り出している
            val partText = text.slice(i, i + pattern.length)
            
            //（:+ リストの最後に要素を付け加えたリストを求める）
            //パターンとマッチじた添字をmatchIndexesシーケンスに加える
            if (isMatch(partText, pattern)) matchIndexes = matchIndexes :+ i
        }

        matchIndexes
    }

    //パターンが切り出した文字と一致したかどうか判定
    def isMatch(textPart: Seq[Char], pattern: Seq[Char]): Boolean = {
        //デフォルト値をtrueに設定
        var isMatch = true
        for ( i <- 0 to pattern.length - 1) {
            //patternより文字数が少ない or i番目の文字がtextPart（= partText）の1番目の文字と!＝なら、isMatch = false   
            if (textPart.length < pattern.length || textPart(i) != pattern(i)) isMatch = false   
        }
        isMatch
    }

    println(s"出現場所：${matchIndexes}") //出現場所：List(8, 20)
}


object Practice1 extends App {
    val text = "カワカドカドカドドワンゴカドカドンゴドワドワンゴドワカワカドンゴドワ"

    println(text.indexOf("ワ"))
    println(text.lastIndexOf("ワ"))
}

//while 式を使って 1 文字でもマッチしなかった場合には、 isMatch 関数内でのループ処理をやめて false の結果を返すように修正
object Practice2 extends App {
    val text = "カワカドカドカドドワンゴカドカドンゴドワドワンゴドワカワカドンゴドワ".toSeq
    val pattern = "ドワンゴ".toSeq

    val matchIndexes = getMatchIndex(text, pattern)

    def getMatchIndex(text: Seq[Char], pattern: Seq[Char]): Seq[Int] = {

        var matchIndexesList = Seq[Int]()

        for (i <- 0 to text.length - 1) {
            val slicedTexts = text.slice(i, i + pattern.length)

            if(isMatch(slicedTexts, pattern)) {
                matchIndexesList = matchIndexesList :+ i
            }
        }
        matchIndexesList
    }

    def isMatch(slicedTexts: Seq[Char], pattern: Seq[Char]): Boolean = {

        var isMatch = true
        var i = 0
        while (isMatch && i <= pattern.length - 1) {
            if (slicedTexts.length < pattern.length || slicedTexts(i) != pattern(i)) isMatch = false
            i = i + 1
        }
        isMatch

    }
    
    println(s"出現場所：${matchIndexes}") //出現場所：List(8, 20)
}