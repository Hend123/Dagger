package com.example.daggertutorial.di

import com.example.daggertutorial.MainActivity
import com.example.daggertutorial.model.Coffee
import dagger.Component
/*
باختصار يعنى اى كمبوننت هو المسؤل يكريت الاوبكت او يعمل وظيفة معينة  بحددهاله وبقوله هيستخدم اى عشان يقدر يعمل الوظيفة وبقوله كمان هيديها لمبن
زى مثال القهوة مين هيعمل القهوة هو بقوله انت محتاج الميه والقهوة وفى الاخر اخلطهم واعملى كوبايه القهوة ف هو بيروح يجيب الميه والقهوة
وبعد كده يعمل القهوة ويروح حطتهم ع بعض ويعمل القهوة وده اسم @Inject
 انه بيحقن الحاجة يعنى بيحقن كوبايه القهوة بالمية والقهوة
 */
@Component
interface CoffeeComponent {
    fun getCoffee():Coffee
    fun inject(mainActivity: MainActivity)
}