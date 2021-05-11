package mrzhang.mashibing.mutithread;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

/** 2. synchronized与volatile的硬件级实现
 * @author zhangnianlei
 * @date 2020/10/29
 */
public class Chapter2 {
	public static void main(String[] args) {

		System.out.println("print Object");
		Object o = new Object();
		System.out.println(ClassLayout.parseInstance(o).toPrintable());

		// java.lang.Object object internals:
		//  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		//       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
		//       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		//       8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
		//      12     4        (loss due to the next object alignment)
		// Instance size: 16 bytes
		// Space losses: 0 bytes internal + 4 bytes external = 4 bytes total

		System.out.println("print lock Object");
		synchronized (o) {
			System.out.println(ClassLayout.parseInstance(o).toPrintable());
		}

		// java.lang.Object object internals:
		//  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		//       0     4        (object header)                           90 c9 b7 04 (10010000 11001001 10110111 00000100) (79153552)
		//       4     4        (object header)                           00 70 00 00 (00000000 01110000 00000000 00000000) (28672)
		//       8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
		//      12     4        (loss due to the next object alignment)
		// Instance size: 16 bytes
		// Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


		System.out.println("print Integer");
		Integer num = new Integer(2);
		System.out.println(ClassLayout.parseInstance(num).toPrintable());

		//print Integer
		//java.lang.Integer object internals:
		// OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		//      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
		//      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		//      8     4        (object header)                           be 22 00 f8 (10111110 00100010 00000000 11111000) (-134208834)
		//     12     4    int Integer.value                             2
		//Instance size: 16 bytes
		//Space losses: 0 bytes internal + 0 bytes external = 0 bytes total


		System.out.println("print char");
		char ch  = 'z';
		System.out.println(ClassLayout.parseInstance(ch).toPrintable());

		//print char
		//java.lang.Character object internals:
		// OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
		//      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
		//      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		//      8     4        (object header)                           1d 21 00 f8 (00011101 00100001 00000000 11111000) (-134209251)
		//     12     2   char Character.value                           z
		//     14     2        (loss due to the next object alignment)
		//Instance size: 16 bytes
		//Space losses: 0 bytes internal + 2 bytes external = 2 bytes total

		System.out.println("print String");
		String string = new String("zhang");
		System.out.println(ClassLayout.parseInstance(string).toPrintable());

		//print String
		//java.lang.String object internals:
		// OFFSET  SIZE     TYPE DESCRIPTION                               VALUE
		//      0     4          (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
		//      4     4          (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		//      8     4          (object header)                           da 02 00 f8 (11011010 00000010 00000000 11111000) (-134216998)
		//     12     4   char[] String.value                              [z, h, a, n, g]
		//     16     4      int String.hash                               0
		//     20     4          (loss due to the next object alignment)
		//Instance size: 24 bytes
		//Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


		System.out.println("print List");
		List list = new ArrayList(4);
		System.out.println(ClassLayout.parseInstance(list).toPrintable());

		//print List
		//java.util.ArrayList object internals:
		// OFFSET  SIZE                 TYPE DESCRIPTION                               VALUE
		//      0     4                      (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
		//      4     4                      (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		//      8     4                      (object header)                           7e 2f 00 f8 (01111110 00101111 00000000 11111000) (-134205570)
		//     12     4                  int AbstractList.modCount                     0
		//     16     4                  int ArrayList.size                            0
		//     20     4   java.lang.Object[] ArrayList.elementData                     [null, null, null, null]
		//Instance size: 24 bytes
		//Space losses: 0 bytes internal + 0 bytes external = 0 bytes total


		System.out.println("print List<String>");
		List<String> liststr = new ArrayList(4);
		System.out.println(ClassLayout.parseInstance(liststr).toPrintable());

		//print List<String>
		//java.util.ArrayList object internals:
		// OFFSET  SIZE                 TYPE DESCRIPTION                               VALUE
		//      0     4                      (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
		//      4     4                      (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		//      8     4                      (object header)                           7e 2f 00 f8 (01111110 00101111 00000000 11111000) (-134205570)
		//     12     4                  int AbstractList.modCount                     0
		//     16     4                  int ArrayList.size                            0
		//     20     4   java.lang.Object[] ArrayList.elementData                     [null, null, null, null]
		//Instance size: 24 bytes
		//Space losses: 0 bytes internal + 0 bytes external = 0 bytes total


		System.out.println("print not null List<String>");
		List<String> notnullliststr = new ArrayList(4);
		notnullliststr.add(string);
		System.out.println(ClassLayout.parseInstance(notnullliststr).toPrintable());

		//print not null List<String>
		//java.util.ArrayList object internals:
		// OFFSET  SIZE                 TYPE DESCRIPTION                               VALUE
		//      0     4                      (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
		//      4     4                      (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
		//      8     4                      (object header)                           7e 2f 00 f8 (01111110 00101111 00000000 11111000) (-134205570)
		//     12     4                  int AbstractList.modCount                     1
		//     16     4                  int ArrayList.size                            1
		//     20     4   java.lang.Object[] ArrayList.elementData                     [(object), null, null, null]
		//Instance size: 24 bytes
		//Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
	}

}
