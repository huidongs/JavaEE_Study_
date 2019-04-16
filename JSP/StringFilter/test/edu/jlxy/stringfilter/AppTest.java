package edu.jlxy.stringfilter;

import org.junit.Test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;


public class AppTest {
	
/*	@Test
	public void testAppInit() {
		String[] initFilters = new String[] { "UPPERCASE_FILTER",
				"LOWERCASE_FILTER", "TRIM_PREFIX_FILTER" };
		App app = new App(initFilters);
		Controller controller = app.getController();
		String[] availableFilters = controller.getAvailableFilters();
		for (int i = 0; i < initFilters.length; i++) {
			Assert.assertEquals(initFilters[i], availableFilters[i]);
		}

	}
	*/
	/*@Test
	public void testAppInitByController() {
		String[] initFilters = new String[] { "UPPERCASE_FILTER",
				"LOWERCASE_FILTER", "TRIM_PREFIX_FILTER" };
		App app = new App(initFilters);
		Controller controller = app.getController();
		String[] availableFilters = controller.getAvailableFilters();
		for (int i = 0; i < initFilters.length; i++) {
			Assert.assertEquals(initFilters[i], availableFilters[i]);
		}
	}
	
	@Test
	public void testAppInitByMockView() {
			String[] initFilters = new String[] { "UPPERCASE_FILTER",
					"LOWERCASE_FILTER", "TRIM_PREFIX_FILTER" };
			App app = new App(initFilters);
			MockView mockView = app.getView();
			String[] availableFilters = mockView.getAvailableFilters();
			for (int i = 0; i < initFilters.length; i++) {
				Assert.assertEquals(initFilters[i], availableFilters[i]);
			}
		}*/
	
	private IFilter[] initFilters = new  IFilter[] { new UpperCaseFilter(),
			new LowerCaseFilter(), new PrefixTrimFilter() };

	private App app;

    @Before
	public void setUp() {
		app = new App(initFilters);
	}

	@Test
	public void testAppInitByController() {
		Controller controller = app.getController();
		IFilter[] availableFilters = controller.getAvailableFilters();
		for (int i = 0; i < initFilters.length; i++) {
			Assert.assertEquals(initFilters[i], availableFilters[i]);
		}
	}
	@Test
	public void testAppInitByMockView() {
		MockView mockView = app.getView();
		IFilter[] availableFilters = mockView.getAvailableFilters();
		for (int i = 0; i < initFilters.length; i++) {
			Assert.assertEquals(initFilters[i], availableFilters[i]);
		}
	}


	@Test
	public void testAddAvailableFilterToFilterChain() {
//		MockView view = app.getView();
//
//		view.addAvailFilterToFilterChain(initFilters[0]);
//
//		List<String> filterChain = view.getFilterChain();
//
//		Assert.assertEquals(1, filterChain.size());
//		Assert.assertEquals(initFilters[0], filterChain.get(0));
		
		MockView view = app.getView();

		// ��ӡ�����ת����������ת����������
		view.addAvailFilterToFilterChain(initFilters[0]);

		// ��֤������ת�����б��еġ�ת������û�б仯
		IFilter[] availableFilters = view.getAvailableFilters();
		Assert.assertEquals(3, availableFilters.length);
		for (int i = 0; i < availableFilters.length; i++) {
			Assert.assertEquals(initFilters[i], availableFilters[i]);
		}

		// ��֤�û�����ӵġ�ת�������Ѿ����뵽��ת����������
		List<IFilter> filterChain = view.getFilterChain();
		Assert.assertEquals(1, filterChain.size());
		Assert.assertEquals(initFilters[0], filterChain.get(0));

		// �ظ������ͬ�ġ�ת������
		view.addAvailFilterToFilterChain(initFilters[0]);

		// ��֤������ת�����б��еġ�ת������û�б仯
		availableFilters = view.getAvailableFilters();
		Assert.assertEquals(3, availableFilters.length);
		for (int i = 0; i < availableFilters.length; i++) {
			Assert.assertEquals(initFilters[i], availableFilters[i]);
		}

		// ��֤��ת������������Ȼֻ��һ��ת�������ظ���ӡ�ת��������Ч
		filterChain = view.getFilterChain();
		Assert.assertEquals(1, filterChain.size());
		Assert.assertEquals(initFilters[0], filterChain.get(0));

		// �������һ����ת������
		view.addAvailFilterToFilterChain(initFilters[1]);

		// ��֤������ת�����б��еġ�ת������û�б仯
		availableFilters = view.getAvailableFilters();
		Assert.assertEquals(3, availableFilters.length);
		for (int i = 0; i < availableFilters.length; i++) {
			Assert.assertEquals(initFilters[i], availableFilters[i]);
		}

		// ��֤�û�����ӵġ�ת�������Ѿ����뵽��ת���������У�������ӵ�˳���Ǵ�ͷ׷�ӵ�β��
		filterChain = view.getFilterChain();
		Assert.assertEquals(2, filterChain.size());
		Assert.assertEquals(initFilters[0], filterChain.get(0));
		Assert.assertEquals(initFilters[1], filterChain.get(1));
	}
	
	public void testRemoveFilterFromFilterChain() {
		MockView view = app.getView();

		// �Ƚ���ת��������ӵ���ת����������
		view.addAvailFilterToFilterChain(initFilters[0]);

		// ��֤�û�����ӵġ�ת�������Ѿ����뵽��ת����������
		List<IFilter> filterChain = view.getFilterChain();
		Assert.assertEquals(1, filterChain.size());
		Assert.assertEquals(initFilters[0], filterChain.get(0));

		// ����ת�������ӡ�ת����������ȥ��
		view.removeFilterFromFilterChain(initFilters[0]);

		// ��֤��ת�����������ޡ�ת������
		filterChain = view.getFilterChain();
		Assert.assertEquals(0, filterChain.size());
	}


	@Test
	public void testApplyFilterChain() {
		MockView view = app.getView();

		// �����ַ���"this is test text."
		view.input("this is test text.");

		// ���Сдת����д�ġ�ת������
		view.addAvailFilterToFilterChain(initFilters[0]);

		// Ӧ��ת���߼�
		view.apply();

		// ��ȡ����ַ���
		String output = view.getOutput();

		// ��֤Сд�Ѿ�ת��Ϊ��д
		Assert.assertEquals("THIS IS TEST TEXT.", output);
	}
	
	@Test
	public void testApplyFilterChain_2() {
		MockView view = app.getView();

		// �����ַ���"this is test text."
		view.input("this is test text.");

		// ���Сдת����д�ġ�ת������
		view.addAvailFilterToFilterChain(initFilters[0]);

		// ��Ӵ�дת��Сд�ġ�ת������
		view.addAvailFilterToFilterChain(initFilters[1]);

		// Ӧ��ת���߼�
		view.apply();

		// ��ȡ����ַ���
		String output = view.getOutput();

		// ��֤Сд�Ѿ�ת��Ϊ��д
		Assert.assertEquals("this is test text.", output);
	}


}



