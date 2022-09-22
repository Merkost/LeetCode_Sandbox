import java.lang.Integer.min

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 1) return strs.first()

        var longestPrefix = strs.maxBy { it.length }
        for(i in 1 until strs.size) {
            findLongestPrefix(strs[i-1], strs[i]).let {
                if (it.length < longestPrefix.length)
                    longestPrefix = it
            }
        }
        return longestPrefix
    }

    fun findLongestPrefix(s: String, s1: String): String {
        var prefix = ""
        val minLength = min(s.length, s1.length)
        var iter = 0
        while (iter < minLength && s[iter] == s1[iter]){
            prefix = prefix.plus(s[iter])
            iter++
        }
        return prefix
    }

}