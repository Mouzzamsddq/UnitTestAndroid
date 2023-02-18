package com.example.unittestandroid

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {

    /**
     * Best practice to create an instance of the class
     */
    private lateinit var resourceComparer: ResourceComparer

    /**
     * initialize instance using before annotation,
     * ... Before annotation run before every test
     */

    @Before
    fun setup() {
        resourceComparer = ResourceComparer()
    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        /**
         * Best practice to getting the object of the context
         */
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "UnitTestAndroid")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse() {
       val context  = ApplicationProvider.getApplicationContext<Context>()
       val result = resourceComparer.isEqual(context, R.string.app_name, "randomString")
        assertThat(result).isFalse()
    }
}