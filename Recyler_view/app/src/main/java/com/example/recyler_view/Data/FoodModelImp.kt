package com.example.recyler_view.Data

class FoodModelImp : FoodModel {
    override fun getFoodList(): MutableList<Food> {

        val foodList = mutableListOf<Food>()

        for (i in 1..10)
        {
            val food = Food(i*101,"Pizza Italian",250,i%2==0,"https://static.toiimg.com/photo/53110049.cms")
            foodList.add(food)
        }
        return foodList
    }

    override fun getFoodItemById(item: Int): Food {
        val foodList = getFoodList()

        foodList.forEach {
            if (it.id== item)
                return it
        }

        return Food(
            101,
            "Pizza Italiano",
            250,
            true,
            "https://static.toiimg.com/photo/53110049.cms"
        )
    }
}
