package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> = this.customers.filter { it.orders.flatMap { it.products }.contains(product) }.toSet()

/*{
    // Return the set of customers who ordered the specified product
    todoCollectionTask()
}*/

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return this.orders.filter { it.isDelivered == true }.flatMap { it.products }.maxBy { it.price }
    //todoCollectionTask()
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.

    return customers.filter { it.orders.flatMap { it.products }.contains(product) }.flatMap { it.orders }.flatMap { it.products }.count { it == product }
    //todoCollectionTask()
}
