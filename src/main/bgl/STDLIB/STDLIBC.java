package STDLIB;

public class STDLIBC {

    public static String imports =
            """
            #include <stdio.h>
            #include<stdbool.h>
            #include<math.h>
            #include <string.h>
            #include <stdlib.h>
            """;

    public static String defines =
            """
            #define foreach(item, array)                         
                for (int keep = 1,                               
                         count = 0,                              
                         size = __builtin_types_compatible_p(typeof(array), char*) ? (strlen(array)): (sizeof(array) / sizeof *(array));\\
                     keep && count != size;                      
                     keep = !keep, count++)                      
                    for (item = (array) + count; keep; keep = !keep)
            """;
}
