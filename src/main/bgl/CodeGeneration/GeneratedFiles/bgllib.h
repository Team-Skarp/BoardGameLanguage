#include <stdio.h>
#include <stdbool.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

#define foreach(item, array)                         \
    for (int keep = 1,                               \
             count = 0,                              \
             size = __builtin_types_compatible_p(typeof(array), char*) ? (strlen(array)): (sizeof(array) / sizeof *(array));\
         keep && count != size;                      \
         keep = !keep, count++)                      \
        for (item = (array) + count; keep; keep = !keep)\

struct Piece {
	char* color;
	void (*move)(struct Piece *self);
	void (*jump)(struct Piece *self);
};
struct Player {
	char* name;
	struct Piece pieces[];
};
struct Tile {
	struct Tile *next;
	struct Tile *prev;
	bool (*isEmpty)(struct Tile *self);
	struct Piece pieces[];
};
