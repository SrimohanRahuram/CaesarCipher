object CaesarCipher extends App {

    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    val E = (c:Char,key:Int,a:String)=>a((a.indexOf(c.toUpper) +key)%a.size)

    val D=(c:Char,key:Int,a:String)=>(
        if(a.indexOf(c)<key)
            (     a(a.indexOf(c.toUpper)-key+a.length())   )
        else
            (      a((a.indexOf(c.toUpper)-key)%a.size)    )
        )

    val cipher= (algo:(Char,Int,String) =>Char,s:String,key:Int,a:String) => s.map(algo(_,key,a))

    var str:String ="HelloZ"

    val ct=cipher(E,str,2,alphabet)
    println(ct)

    val pt=cipher(D,ct,2,alphabet)
    println(pt)
}
