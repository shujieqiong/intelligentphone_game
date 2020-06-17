package com.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.data.AddData;
import com.data.CommonDatas;
import com.example.funnymath.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class AddActivity extends Activity implements TextToSpeech.OnInitListener {

	// ViewPager是google SDk中自带的一个附加包的一个类，可以用来实现屏幕间的切换。
	// android-support-v4.jar
	private ViewPager mPager;// 页卡内容
	private List<View> listViews; // Tab页面列表
	private TextView textView_head;// 页卡头标
	private int offset = 0;// 动画图片偏移量
	private int currIndex = 0;// 当前页卡编号

	private View page0;
	private View page1;
	private View page2;
	private View page3;
	private View page4;
	private View page5;
	private View page6;
	private View page7;
	private View page8;
	private View page9;

	private TextView textView;
	private RadioGroup radioGroup;
	private RadioButton radioButtonA;
	private RadioButton radioButtonB;
	private RadioButton radioButtonC;
	private RadioButton radioButtonD;
	private Random random = new Random();
	private int rightFlag;	//判断选项是否正确
	private ImageView  imageView_difficulty;
	private ImageView  imageView_voice;
	private ImageView  imageView_help;
	private ImageView  imageView_teach;
	private TextToSpeech tts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		tts = new TextToSpeech(this,this);//语音

		InitTextView(); // 初始化头标
		InitViewPager(); // 初始化ViewPager
	}

	/**
	 * 初始化头标
	 */
	private void InitTextView() {
		textView_head = (TextView) findViewById(R.id.text);
		textView_head.setText("NO.1");
		textView_head.setOnClickListener(new MyOnClickListener(0));
	}


	private void InitViewPager() {
		mPager = (ViewPager) findViewById(R.id.vPager);
		///**装分页显示的view的数组*/
		listViews = new ArrayList<View>();//设置tab页面的动态数组，//将要分页显示的View装入数组中，里面的类型是<>中的
		LayoutInflater mInflater = getLayoutInflater();//对于一个没有被载入或者想要动态载入的界面，都需要使用LayoutInflater.inflate()来载入；
		//载入10个界面
		page0 = mInflater.inflate(R.layout.add_pager, null);
		page1 = mInflater.inflate(R.layout.add_pager, null);
		page2 = mInflater.inflate(R.layout.add_pager, null);
		page3 = mInflater.inflate(R.layout.add_pager, null);
		page4 = mInflater.inflate(R.layout.add_pager, null);
		page5 = mInflater.inflate(R.layout.add_pager, null);
		page6 = mInflater.inflate(R.layout.add_pager, null);
		page7 = mInflater.inflate(R.layout.add_pager, null);
		page8 = mInflater.inflate(R.layout.add_pager, null);
		page9 = mInflater.inflate(R.layout.add_pager, null);
		listViews.add(page0);
		listViews.add(page1);
		listViews.add(page2);
		listViews.add(page3);
		listViews.add(page4);
		listViews.add(page5);
		listViews.add(page6);
		listViews.add(page7);
		listViews.add(page8);
		listViews.add(page9);
		mPager.setAdapter(new MyPagerAdapter(listViews));
		mPager.setCurrentItem(0);//设置当前页面
		// 对add_page0中的数据初始化
		initAddPage(page0);
		setData();
		//对viewPager添加页面监听
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
			//Toast.makeText(AddActivity.this, "成功输出语音", Toast.LENGTH_SHORT).show();
			// 设置使用美式英语朗读
			int result = tts.setLanguage(Locale.US);
			//int result = tts.setLanguage(Locale.CHINA);//指定当前阅读的是中文

			// 如果不支持所设置的语言
			if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE
					&& result != TextToSpeech.LANG_AVAILABLE) {
				Toast.makeText(AddActivity.this, "TTS暂时不支持这种语言的朗读",
						Toast.LENGTH_LONG).show();
			}
		}
	}

	/**
	 * ViewPager适配器，实现屏幕左右平滑切换的一个类
	 */
	public class MyPagerAdapter extends PagerAdapter {
		public List<View> mListViews;

		public MyPagerAdapter(List<View> mListViews) {
			this.mListViews = mListViews;
		}//

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(mListViews.get(arg1));
		}//  //销毁position位置的界面
		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public int getCount() {
			return mListViews.size();
		}// //获取当前窗体界面数

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(mListViews.get(arg1), 0);
			return mListViews.get(arg1);
		}////初始化position位置的界面

		@Override//// 判断是否由对象生成界面
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == (arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}
	}

	/**
	 * 头标点击监听
	 */
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			mPager.setCurrentItem(index);
		}
	};

	/**
	 * 页卡切换监听
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {

		//页面跳转完后得到调用，arg0是你当前选中的页面的Position（位置编号）。
		public void onPageSelected(int arg0) {
			//arg0：将要切换的目的页面
			switch (arg0) {

				case 0:
				if (currIndex == 1) {
					textView_head.setText("NO.1");
				} 
				break;
			case 1:
				if (currIndex == 0) {
					textView_head.setText("NO.2");
					initAddPage(page1);
					setData();
				} else if (currIndex == 2) {
					textView_head.setText("NO.2");
				}
				break;
			case 2:
				if (currIndex == 1) {
					textView_head.setText("NO.3");
					initAddPage(page2);
					setData();
				} else if (currIndex == 3) {
					textView_head.setText("NO.3");
				}
				break;
			case 3:
				if (currIndex == 2) {
					textView_head.setText("NO.4");
					initAddPage(page3);
					setData();
				} else if (currIndex == 4) {
					textView_head.setText("NO.4");
				}
				break;
			case 4:
				if (currIndex == 3) {
					textView_head.setText("NO.5");
					initAddPage(page4);
					setData();
				} else if (currIndex == 5) {
					textView_head.setText("NO.5");
				}
				break;
			case 5:
				if (currIndex == 4) {
					textView_head.setText("NO.6");
					initAddPage(page5);
					setData();
				} else if (currIndex == 6) {
					textView_head.setText("NO.6");
					//从页面6切换到页面5（向右滑）
				}
				break;
			case 6:
				if (currIndex == 5) {
					textView_head.setText("NO.7");

					initAddPage(page6);
					setData();
				} else if (currIndex == 7) {
					textView_head.setText("NO.7");
				}
				break;
			case 7:
				if (currIndex == 6) {
					textView_head.setText("NO.8");

					initAddPage(page7);
					setData();
				} else if (currIndex == 8) {
					textView_head.setText("NO.8");

				}
				break;
			case 8:
				if (currIndex == 7) {
					textView_head.setText("NO.9");

					initAddPage(page8);
					setData();
				} else if (currIndex == 9) {
					textView_head.setText("NO.9");

				}
				break;
			case 9:
				if (currIndex == 8) {
					textView_head.setText("NO.10");

					initAddPage(page9);
					setData();
				} 
				break;
			}
			currIndex = arg0;
		}


		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

	////此方法是在状态改变的时候调用，其中arg0这个参数

		//有三种状态（0，1，2）。arg0 ==1的时辰默示正在滑动，arg0==2的时辰默示滑动完毕了，arg0==0的时辰默示什么都没做。
		public void onPageScrollStateChanged(int arg0) {
		}
	}

	public void changeToNext() //如果答对了跳到下一页
	{
		final int nowItem = mPager.getCurrentItem();//得到当前页面
		if (nowItem < listViews.size()-1) {//小于页面总数
			mPager.setCurrentItem(nowItem+1);//如果答对了就自动跳到下一个页面
		} 
	}
	
	class myCheckedChangeListener implements OnCheckedChangeListener {
		//将点的id与正确答案相对比
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			switch (checkedId) {
			case R.id.add_radioButtonA:
				if (getRightFlag() == 1) {
					Toast.makeText(getApplicationContext(), "恭喜你，答对了！",
							Toast.LENGTH_SHORT).show();
					changeToNext();
				} else {
					Toast.makeText(getApplicationContext(), "不对，再想想~",
							Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.add_radioButtonB:
				if (getRightFlag() == 2) {
					Toast.makeText(getApplicationContext(), "恭喜你，答对了！",
							Toast.LENGTH_SHORT).show();
					changeToNext();
				} else {
					Toast.makeText(getApplicationContext(), "不对，再想想~",
							Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.add_radioButtonC:
				if (getRightFlag() == 3) {
					Toast.makeText(getApplicationContext(), "恭喜你，答对了！",
							Toast.LENGTH_SHORT).show();
					changeToNext();
				} else {
					Toast.makeText(getApplicationContext(), "不对，再想想~",
							Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.add_radioButtonD:
				if (getRightFlag() == 4) {
					Toast.makeText(getApplicationContext(), "恭喜你，答对了！",
							Toast.LENGTH_SHORT).show();
					changeToNext();
				} else {
					Toast.makeText(getApplicationContext(), "不对，再想想~",
							Toast.LENGTH_SHORT).show();
				}
				break;
			default:
				break;
			}
		}

	}

	public int getRightFlag() {
		return rightFlag;
	}

	public void setRightFlag(int rightFlag) {
		this.rightFlag = rightFlag;
	}//随机产生选项

	public void setData() {
		AddData addData = new AddData(CommonDatas.getStander());//设置commmondate类里的一个静态方法判断难易，静态变量直接用类名.方法名可以点出来
		textView.setText(addData.getQuestion());
		setRightFlag(random.nextInt(4) + 1);//随机选择一个正确答案，然后this.rightFlag设置好正确答案
		switch (rightFlag) {
		case 1:
			radioButtonA.setText("" + addData.getAnswer());
			radioButtonB.setText("" + addData.getAnswer1());
			radioButtonC.setText("" + addData.getAnswer2());
			radioButtonD.setText("" + addData.getAnswer3());
			break;
		case 2:
			radioButtonB.setText("" + addData.getAnswer());
			radioButtonA.setText("" + addData.getAnswer1());
			radioButtonC.setText("" + addData.getAnswer2());
			radioButtonD.setText("" + addData.getAnswer3());
			break;
		case 3:
			radioButtonC.setText("" + addData.getAnswer());
			radioButtonA.setText("" + addData.getAnswer1());
			radioButtonB.setText("" + addData.getAnswer2());
			radioButtonD.setText("" + addData.getAnswer3());
			break;
		case 4:
			radioButtonD.setText("" + addData.getAnswer());
			radioButtonA.setText("" + addData.getAnswer1());
			radioButtonB.setText("" + addData.getAnswer2());
			radioButtonC.setText("" + addData.getAnswer3());
			break;
		default:
			break;
		}
		//给radioGroup添加监听器
		radioGroup.setOnCheckedChangeListener(new myCheckedChangeListener());
	}
//对页面进行初始化
	private void initAddPage(View view) {
		textView = (TextView) view.findViewById(R.id.add_textView);
		radioGroup = (RadioGroup) view.findViewById(R.id.add_radioGroup);
		radioButtonA = (RadioButton) view.findViewById(R.id.add_radioButtonA);
		radioButtonB = (RadioButton) view.findViewById(R.id.add_radioButtonB);
		radioButtonC = (RadioButton) view.findViewById(R.id.add_radioButtonC);
		radioButtonD = (RadioButton) view.findViewById(R.id.add_radioButtonD);
		imageView_difficulty = (ImageView) view.findViewById(R.id.imageView_difficulty);
		imageView_voice = (ImageView) view.findViewById(R.id.imageView_voice);
		imageView_help = (ImageView) view.findViewById(R.id.imageView_help);
		imageView_teach = (ImageView) view.findViewById(R.id.imageView_teach);
		//难度选择
		imageView_difficulty.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//如果flag=false,stander=0;
				if (!CommonDatas.isFlag()) {
					CommonDatas.setStander(1);
					CommonDatas.setFlag(true);
					//重新设置数据
					setData();
				} else if (CommonDatas.isFlag()) {
					CommonDatas.setStander(0);
					CommonDatas.setFlag(false);
					//重新设置数据
					setData();
				}
			}
		});

		imageView_help.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(AddActivity.this);

				builder.setTitle("提示：");
				builder.setMessage("再想想吧，不要放弃哦！");
				builder.setPositiveButton("好的", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				AlertDialog dialog = builder.create();
				dialog.show();

			}
		});
		imageView_teach.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						AddActivity.this);
				builder.setTitle("加法：");
				builder.setMessage("有些连加试题，我们可以根据数字的特点采用“凑十法”进行简单计算。");
				builder.setPositiveButton("好的",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
												int which) {
								dialog.dismiss();
							}
						});
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
		imageView_voice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				tts.speak(textView.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
			}
		});
	}
}
