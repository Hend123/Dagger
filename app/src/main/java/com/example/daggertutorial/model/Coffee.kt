package com.example.daggertutorial.model

import android.util.Log
import javax.inject.Inject

// No DI
// Problem1 : Testing
// Problem2 : Copling (new instante)
// لو انا عاوزة اغير نوع القهوة او المية هغير من هنا عشان كده مافيش اى اعتمادة وكل السيطرة هنا عشان كده هنقلب السيطرة (Inversion of control IOC)
// ---------------------------------------------
// Manual DI(هنا بنجيب كل اوبجكت محتاجاه جوه الكلاس ابصيه من بره عن طريق الاكونستركتور والمثود)
// او ممكن اعمل كلاس فيه مثودز بترجعلى الاوبجكتز اللى انا عاوزاه وده اسمه service locator pattern
// وهنا بطريقة دى قلبنا السيطرة من الكلاس لبره الكلاس ونقدر نعكل تست واتخلصنا من copling وبردو نقدر نغير برحتنا نوع تانى من القهوة وده كله من بره
// Problem here : Boilerplate code
// ---------------------------------------
// Auto DI (Dagger2)
// عشان نحل مشكلة الbiolerplate code هنجيب حد يوفر لينا الاكواد دى ويعملها هو بنفسه هو بيكون اauto DI
//عشان اى حد يقدر يعمل اوتو بيعمل جراف فيه كل الديبنسسس وفى اتجاه واحد Dependencies Acyclic Grahp
//واللى بيعمل الجراف هو الدجر  واخدوا اسم داجر من الجراف  واضفوا er عشان اى حاجة فى اللغة الانجليزية بتعمل حاجة بنضفلها er
//----------------------------
//------------ Dagger 2 -------------------------
// @Component  ده اللى بيعرف الدابينسس اللى ف الجراف  وبيعمل القهوة مثلا او بكريت اوبجكت  او ان كلاس مثلا عاوز اتنين اوبكجت ف الكومبونت
// بيكون عارف ان الكلاس ده محتاج اتنين اوبكت عشان يكريته ف بيعمل اوبجكت من الاتنين كلاسس ويبصيها للتلات وبكده عملنا الوبجكت الثالث
// @component is interface  عشان هو  مش بنكتب فيه اكواد كتير وهو بيعمل حاجات كتير ف دجر بتسهلنا الدنيا وهى اللى بتعمل الكواد وتولدها بنفسها
// @inject عشان يقدر يعرفها label  دى الديبنسس اللى هيستخدمها الكومبونت بدلها
// @component and @inject are annotation processor
// بيساعدوا دجر تعرف اى هى الديبنسس وكل واحد عبارة عن اى عشان تولد لينا الكود الكتير وتريحنا
//------------- 3 Types of Injection of Dagger ----------
/*
1. Constractor Injection -> دجر بتعرف الديبنسس اللى تقدر تستخدمها  عن طريق الكونستركتور
2. Field Injection -> دجر بتعرف الديبنسس عن طريق المتغيرات جوه الكلاس
-> ال field مش ينفع يكون private  ولاconst
->
بنستخدمه لو مثلا عاوزة ابصى حاجة لكلاس بس مش عن طريق الكومسنركتور او المثود ومفيد بردو فى لو عاوزة اوبكت
 اعرفه ف الاكتفتى او الفرجمنت عشان مش بقدر اكسس ع الكونستركتور بتاعهم
 ف اساسا الاوبجكت بتاع الاكتفتى او فرجمنت موجود عن طريق الاندرويد libs هى بتدعمنا بيه
 وزى ما معروف ان الدجر بتمشى ع الكونستركتور الاول ثم الفيلد ثم المثود اوتامتيكى
 ف انا عاوزة اوبجكت من الاكتفتى عشان يقدر الدجر  يكسس وياسين القيمة للفيلد عشان بردو مش ينفع ادخل كده ع الاكتفتى واكتب فوق الكونستركتور بتاعها inject
 ف بعمل فانكشن جوه الكمبونتنت وبنباصى ليها الاكتفتى من الاكتفتى وبقوله الاكتفتى اهه,
 يعنى بباصى الاكتفتى نفسها ولا ابستركت كلاس بترثه ولا اى حاجة عشان دجر تعرف هتدخل ع اى
 -> هنا ف عيب بيظهر هو ال copling between dagger and class اللى فيه field injection
3. Method Injection -> هنا اللى موجوده فى المثود اللى بتكون براميتر للمثود
// دجر بتمشى ازاى الاول ع الكونستركتور وبعد كده الfields then auto methods  يعنى بيروح للمثود من غير ماانديها
// لو انا عندى مثود عاوزاها تحصل كل ما استخدم كلاس معين هعملها انجكت ودجر هتنديها لوحدها عشان نحارب ال boilerplate code  عشان هفضل انديها كل ما استخدم الكلاس ده
 */
class Coffee @Inject constructor() {
    // Field Injection
    @Inject
    lateinit var river: River

    @Inject
    lateinit var farm: Farm

    /*
// Constractor injection
   @Inject
   constructor(river: River, farm: Farm) {
       Log.d(LOG_TAG, "Coffee: ")
       this.river = river
       this.farm = farm
  }
*/
    // Method Injection
    @Inject
    fun checkElectricity(){
        Log.d(LOG_TAG, "checkElectricity: connecting ... ")
    }

    fun getCoffeeCup(): String {
        return farm.getBeans() + "+" + river.getWater()
    }

    companion object {
        private const val LOG_TAG = "Test"
    }
}