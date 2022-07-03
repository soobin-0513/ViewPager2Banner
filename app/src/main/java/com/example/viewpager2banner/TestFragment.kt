package com.example.viewpager2banner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_test.*


class TestFragment : Fragment() {

    //이미지랑텍스트가 준비된 컨테이너에
    private var image: Int? = null
    private var text: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            image = it.getInt("image",0)
            text = it.getString("text","")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView2.setImageResource(image!!)
        textView2.text = text
    }

    companion object{
        //외부에서 이미지랑 텍스트 가져오는 파라미터
        fun newInstance(image:Int, text:String) =
            TestFragment().apply {
                arguments = Bundle().apply {
                    putInt("image",image)
                    putString("text",text)
                }
            }
    }
}