package com.example.viewpager2banner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_test.*

class TestFragment : Fragment() {

    //이미지랑 텍스트가 준비된 컨테이너에
    private var image: Int? = null
    private var text: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //실행하면서 newInstance 저장된 이미지/텍스트를 불러온다
        arguments?.let {
            image = it.getInt("image",0)
            text = it.getString("text","")
        }
    }

    //onCreateView  XML 레이아웃을 inflate(인플레이트) 하는 곳입니다.
    //View 객체를 얻을 수 있으므로, 버튼이나 텍스트뷰 등을 초기화 할 수 있다
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_test,container,false)
    }

    //onCreateView()를 통해 반환된 view 객체를 파라미터로 전달된다
    //view의 초기값을 설정해주기 적절하다
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView2.setImageResource(image!!)
        textView2.text = text
    }

    companion object{
        //외부에서 이미지랑 텍스트 가져오는 파라미터
        fun newInstance(image:Int, text:String) =
            TestFragment().apply {
                //kye,value 형식으로 값을 저장
                arguments = Bundle().apply {
                    putInt("image",image)
                    putString("text",text)
                }
            }
    }
}