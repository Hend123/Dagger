package com.example.daggertutorial.di

import com.example.daggertutorial.MainActivity
import com.example.daggertutorial.model.Coffee
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

/*
باختصار يعنى اى كمبوننت هو المسؤل يكريت الاوبكت او يعمل وظيفة معينة  بحددهاله وبقوله هيستخدم اى عشان يقدر يعمل الوظيفة وبقوله كمان هيديها لمبن
زى مثال القهوة مين هيعمل القهوة هو بقوله انت محتاج الميه والقهوة وفى الاخر اخلطهم واعملى كوبايه القهوة ف هو بيروح يجيب الميه والقهوة
وبعد كده يعمل القهوة ويروح حطتهم ع بعض ويعمل القهوة وده اسم @Inject
 انه بيحقن الحاجة يعنى بيحقن كوبايه القهوة بالمية والقهوة
 */
@Component(modules = [CoffeeModule::class])
interface CoffeeComponent {
    fun getCoffee():Coffee
    fun inject(mainActivity: MainActivity)
    //عشان اعرف دجر ان ده تبع ال component مش تبعه هو هضيف النوتشن ده
    @Component.Builder
    interface Builder{
        //لازم يكون فيه مثود ع الاقل بترجع CoffeeComponent
        fun build():CoffeeComponent
        //هنا بقا هعرف كل الديبنسس اللى محتاجها عبارة عن مثود بتاخد اللى انا عاوزاه وبترجع Builder عشان اقدر انادى بقيت المثود اللى فى الBuilder
        // وده اسمه Builder Design Pattern واحط نوتشن فوقيها عشان دجر يعرف ان ده ديبنسس

        @BindsInstance
        fun suger(@Suger suger: Int):Builder
        @BindsInstance
        fun milk( @Milk milk: Int):Builder
    }
}