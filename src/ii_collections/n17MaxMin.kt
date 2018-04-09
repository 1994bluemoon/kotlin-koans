package ii_collections

import java.time.OffsetDateTime

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    var array: ArrayList<Int> = ArrayList()
    for (cus in this.customers){
        array.add(cus.orders.count())
    }
    var max = array.max()
    var pos = 0
    for (i in array){
        if (max == array[i])
            pos =i
    }
    return this.customers.get(pos)
}
/*{
    // Return a customer whose order count is the highest among all customers
    todoCollectionTask()
}*/

fun Customer.getMostExpensiveOrderedProduct(): Product? {
    // Return the most expensive product which has been ordered
    //todoCollectionTask()
    var price: ArrayList<Double> = ArrayList()
    var maxPrice: Double = 0.0
    for (product in this.orderedProducts){
        price.add(product.price)
    }
    maxPrice = price.max()!!
    var pos = 0
    for (i in 0..price.size - 1){
        if (maxPrice == price[i])
            pos = i
    }
    return this.orderedProducts.toList().get(pos)

}
