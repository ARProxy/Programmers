import java.io.*

data class Node(val value: Char, var left: Char? = null, var right: Char? = null)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val tree = mutableMapOf<Char, Node>()

    repeat(n) {
        val (parent, left, right) = br.readLine().split(" ")
        tree[parent[0]] = Node(parent[0], left[0].takeIf { it != '.' }, right[0].takeIf { it != '.' })
    }

    val root = tree['A']!!

    fun preorder(node: Node?) {
        if (node == null) return
        print(node.value)
        preorder(tree[node.left])
        preorder(tree[node.right])
    }

    fun inorder(node: Node?) {
        if (node == null) return
        inorder(tree[node.left])
        print(node.value)
        inorder(tree[node.right])
    }

    fun postorder(node: Node?) {
        if (node == null) return
        postorder(tree[node.left])
        postorder(tree[node.right])
        print(node.value)
    }

    preorder(root)
    println()
    inorder(root)
    println()
    postorder(root)
}