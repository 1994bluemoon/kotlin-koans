package ii_collections

import v_builders.data.getProducts

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() = this.orders.flatMap { it.products }.toSet()

/*{
    var products: ArrayList<Product> = ArrayList()
    for (order in this.orders){
        for (product in order.products){
            products.add(product)
        }
    }
    return products.toSet()
}*/

/*{
    // Return all products this customer has ordered
    todoCollectionTask()
}
*/
val Shop.allOrderedProducts: Set<Product> get() = this.customers.flatMap { it.orders }.flatMap { it.products }.toSet()

/*{
    var product: ArrayList<Product> = ArrayList()
    for (cus in this.customers){
        for (pro in cus.orderedProducts){
            if (!product.contains(pro)){
                product.add(pro)
            }
        }
    }
    return product.toSet()
}*/

/*{
    // Return all products that were ordered by at least one customer
    todoCollectionTask()
}
*/