#include "queue.h"
#include <stdlib.h>

typedef struct Queue {
		void *front;
		void *back;
		int size;
		void **array;
} myQueue;

void* queue_new(int numItems) {
	myQueue *newQueue = (myQueue *) malloc(sizeof(myQueue));
	newQueue->size = numItems;
	newQueue->array = (void *) malloc(sizeof(void *) * numItems);
	newQueue->front = newQueue->array[0];
	newQueue->back = newQueue->array[numItems - 1];
	return (void *) newQueue;
}

void queue_enqueue(void *q, void *item) {
	
}

void* queue_dequeue(void *q) {

}

int queue_isEmpty(void *q) {

}
