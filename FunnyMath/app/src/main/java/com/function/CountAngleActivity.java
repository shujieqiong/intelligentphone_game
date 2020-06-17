package com.function;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.data.AddData;
import com.data.CommonDatas;
import com.data.CommonVoid;
import com.data.CountAngleData;
import com.data.dataBaseObject;
import com.example.funnymath.R;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class CountAngleActivity extends Activity {
	private ViewPager mPager;// 页卡内容
	private List<View> listViews; // Tab页面列表
	private TextView textView_head;// 页卡头标

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


	//定义设置
private  ImageView angle_imageViewsst;
	private ImageView angle_imageView;//给中心图片中加图
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

	private ArrayList<dataBaseObject> datalist = new ArrayList<dataBaseObject>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_countangle);

		InitTextView(); // 初始化头标
		InitViewPager(); // 初始化ViewPager
	}

	/**
	 * 初始化头标
	 */
	private void InitTextView() {//给第一页进行初始化
		textView_head = (TextView) findViewById(R.id.text);//text的标题
		textView_head.setText("NO.1");
		textView_head.setOnClickListener(new MyOnClickListener(0));
	}

	/**
	 * 初始化ViewPager
	 */
	private void InitViewPager() {
		mPager = (ViewPager) findViewById(R.id.vPager);//先进入有标题的一页，然后调用对应的vager，把设置好的图片加进去
		listViews = new ArrayList<View>();
		LayoutInflater mInflater = getLayoutInflater();
		page0 = mInflater.inflate(R.layout.countangle_pager, null);
		page1 = mInflater.inflate(R.layout.countangle_pager, null);
		page2 = mInflater.inflate(R.layout.countangle_pager, null);
		page3 = mInflater.inflate(R.layout.countangle_pager, null);
		page4 = mInflater.inflate(R.layout.countangle_pager, null);
		page5 = mInflater.inflate(R.layout.countangle_pager, null);
		page6 = mInflater.inflate(R.layout.countangle_pager, null);
		page7 = mInflater.inflate(R.layout.countangle_pager, null);
		page8 = mInflater.inflate(R.layout.countangle_pager, null);
		page9 = mInflater.inflate(R.layout.countangle_pager, null);
		listViews.add(page0);//将要分页显示的View装入数组中
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
		mPager.setCurrentItem(0);//使用ViewPager的setCurrentItem (int item) 方法设置其初始显示的页面，
		// 对add_page0中的数据初始化
		initAddPage(page0);
		setData();
		//对viewPager添加页面监听
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}
/**
	 * ViewPager适配器
	 */
	public class MyPagerAdapter extends PagerAdapter {
		public List<View> mListViews;//xiangdanyu

		public MyPagerAdapter(List<View> mListViews) {
			this.mListViews = mListViews;
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(mListViews.get(arg1));
		}

		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public int getCount() {
			return mListViews.size();
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(mListViews.get(arg1), 0);
			return mListViews.get(arg1);
		}

		@Override
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

		@Override
		public void onPageSelected(int arg0) {
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
					initAddPage(page3);//给第3张中心图片加图
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

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}

	public void changeToNext() {
		final int nowItem = mPager.getCurrentItem();
		if (nowItem < listViews.size()-1) {
			mPager.setCurrentItem(nowItem+1);
		} 
	}
	
	class myCheckedChangeListener implements OnCheckedChangeListener {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			switch (checkedId) {
			case R.id.angle_radioButtonA:
				if (getRightFlag() == 1) {
					Toast.makeText(getApplicationContext(), "恭喜你，答对了！",
							Toast.LENGTH_SHORT).show();
					changeToNext();
				} else {
					Toast.makeText(getApplicationContext(), "不对，再想想~",
							Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.angle_radioButtonB:
				if (getRightFlag() == 2) {
					Toast.makeText(getApplicationContext(), "恭喜你，答对了！",
							Toast.LENGTH_SHORT).show();
					changeToNext();
				} else {
					Toast.makeText(getApplicationContext(), "不对，再想想~",
							Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.angle_radioButtonC:
				if (getRightFlag() == 3) {
					Toast.makeText(getApplicationContext(), "恭喜你，答对了！",
							Toast.LENGTH_SHORT).show();
					changeToNext();
				} else {
					Toast.makeText(getApplicationContext(), "不对，再想想~",
							Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.angle_radioButtonD:
				if (getRightFlag() == 4) {
					Toast.makeText(getApplicationContext(), "恭喜你，答对了！",
							Toast.LENGTH_SHORT).show();
					changeToNext();//只有答对了，才显示下一个页面
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
	}

	public void setData() {
		datalist.add(CommonVoid.makeShuJiaoQuestion());
		CountAngleData countAngleData = (CountAngleData) datalist.get(currIndex);

		Bitmap bitmap = countAngleData.getQuestionBitmap();//获得所画代码
		angle_imageView.setImageBitmap(bitmap);
		setRightFlag(random.nextInt(4) + 1);
		switch (rightFlag) {
		case 1:
			radioButtonA.setText("" + countAngleData.getAnswer());
			radioButtonB.setText("" + countAngleData.getAnswer1());
			radioButtonC.setText("" + countAngleData.getAnswer2());
			radioButtonD.setText("" + countAngleData.getAnswer3());
			break;
		case 2:
			radioButtonB.setText("" + countAngleData.getAnswer());
			radioButtonA.setText("" + countAngleData.getAnswer1());
			radioButtonC.setText("" + countAngleData.getAnswer2());
			radioButtonD.setText("" + countAngleData.getAnswer3());
			break;
		case 3:
			radioButtonC.setText("" + countAngleData.getAnswer());
			radioButtonA.setText("" + countAngleData.getAnswer1());
			radioButtonB.setText("" + countAngleData.getAnswer2());
			radioButtonD.setText("" + countAngleData.getAnswer3());
			break;
		case 4:
			radioButtonD.setText("" + countAngleData.getAnswer());
			radioButtonA.setText("" + countAngleData.getAnswer1());
			radioButtonB.setText("" + countAngleData.getAnswer2());
			radioButtonC.setText("" + countAngleData.getAnswer3());
			break;
		default:
			break;
		}
		//给radioGroup添加监听器
		radioGroup.setOnCheckedChangeListener(new myCheckedChangeListener());
	}

	private void initAddPage(View view) {
		angle_imageView = (ImageView)view.findViewById(R.id.angle_imageView);
		textView = (TextView) view.findViewById(R.id.angle_textView);
		radioGroup = (RadioGroup) view.findViewById(R.id.angle_radioGroup);
		radioButtonA = (RadioButton) view.findViewById(R.id.angle_radioButtonA);
		radioButtonB = (RadioButton) view.findViewById(R.id.angle_radioButtonB);
		radioButtonC = (RadioButton) view.findViewById(R.id.angle_radioButtonC);
		radioButtonD = (RadioButton) view.findViewById(R.id.angle_radioButtonD);
		imageView_difficulty = (ImageView) view.findViewById(R.id.imageView_difficulty);
		imageView_voice = (ImageView) view.findViewById(R.id.imageView_voice);
		imageView_help = (ImageView) view.findViewById(R.id.imageView_help);
		imageView_teach = (ImageView) view.findViewById(R.id.imageView_teach);
		imageView_difficulty.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(CountAngleActivity.this);

				builder.setTitle("提示：");
				builder.setMessage("当前已是最高难度了！");
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

		imageView_help.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent =new Intent(CountAngleActivity.this,shujiaotishi.class);
				CountAngleActivity.this.startActivity(intent);
}
		});
	imageView_teach.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						CountAngleActivity.this);
				builder.setTitle("数角方法：");
				builder.setMessage("单独一个一个地数，两个组成为一个地数......或用更高级的排列组合公式算。");
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

	}
}
