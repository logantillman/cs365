// Author: Logan Tillman

#include "queue.h"
#include <stdlib.h>
#include <stdio.h>

typedef struct Queue {
	void *front;
	void *back;
	int maxSize;
	int size;
	void **array;
} myQueue;

void *queue_new(int numItems) {
	myQueue *newQueue = (myQueue *) malloc(sizeof(myQueue));
	newQueue->maxSize = numItems;
	newQueue->array = (void *) malloc(sizeof(void *) * numItems);
	newQueue->size = 0;
	return (void *) newQueue;
}

void queue_enqueue(void *q, void *item) {
	myQueue *queue = (myQueue *) q;
	
	if (queue->size == queue->maxSize) {
		return;
	}

	if (queue->size == 0) {
		queue->front = item;
	}
	
	queue->array[queue->size] = item;
	queue->back = queue->array[queue->size];
	queue->size++;
}

void *queue_dequeue(void *q) {
	myQueue *queue = (myQueue *) q;
	
	void *rv = queue->front;

	int i;
	for (i = 1; i < queue->size; i++) {
		queue->array[i - 1] = queue->array[i];
	}

	if (queue->size > 0) {
		queue->front = queue->array[0];
	}

	queue->size--;
	return rv;
}

int queue_isEmpty(void *q) {
	myQueue *queue = (myQueue *) q;
	if (queue->size == 0) {
		return 1;
	}
	else {
		return 0;
	}
}
