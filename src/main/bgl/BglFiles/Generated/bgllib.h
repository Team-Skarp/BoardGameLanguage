#include <stdio.h>
#include <stdbool.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#define foreach(item, array)                         \
    for (int keep = 1,                               \
             count = 0,                              \
             size = __builtin_types_compatible_p(typeof(array), char*) ? (strlen(array)): (sizeof(array) / sizeof *(array));\
         keep && count != size;                      \
         keep = !keep, count++)                      \
        for (item = (array) + count; keep; keep = !keep)\

struct Tile {
	bool back_track_allowed;
	int p_count;
	struct Tile *next;
	struct Tile *prev;
};
struct Piece {
	int id;
	struct Tile position;
	void (*move)(struct Piece *self,int steps);
	void (*jump)(struct Piece *self,struct Tile to);
};
void move(struct Piece *self,int steps) {
	int i = 0;
	while( ( i < steps ) ){
		self.jump(&self,self.position.next);
}}
void jump(struct Piece *self,struct Tile *to) {
	self.position = to;
	to.p_count =  ( to.p_count + 1 ) ;
}
struct Player {
	int id;
	char* name;
	struct Piece pieces[25];
};
struct Path {
	int dirType;
	int length;
	struct Tile head;
	struct Tile tail;
	void (*_pinit)(struct Path *self);
	struct Tile tiles[25];
};
void _pinit(struct Path *self) {
	bool bta = false;
	if( ( dirType==1 ) ){
		bta = true;}else{
		bta = false;}	struct Tile tile = {bta};
	self.head = tile;
	self.tail = tile;
	self.tiles[1 - 1] = tile;
	int i = 2;
	while( ( i <= self.length ) ){
		tile.prev = self.tail;
		self.tail.next = tile;
		self.tail = tile;
		self.tiles[i - 1].next = tile;
}	int len = self.length;
	self.tiles[1 - 1].prev = self.tiles[len - 1];
	self.tiles[len - 1].next = self.tiles[1 - 1];
}
