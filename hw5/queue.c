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
	printf("Created the queue\n");
	myQueue *newQueue = (myQueue *) malloc(sizeof(myQueue));
	newQueue->maxSize = numItems;
	newQueue->array = (void *) malloc(sizeof(void *) * numItems);
	newQueue->size = 0;
	newQueue->front = newQueue->array[0];
	return (void *) newQueue;
}

void queue_enqueue(void *q, void *item) {
	printf("Created the queue\n");
	myQueue *queue = (myQueue *) q;
	queue->array[queue->size] = item;
	queue->back = queue->array[queue->size];
	queue->size++;
}

void *queue_dequeue(void *q) {
	printf("Created the queue\n");
	myQueue *queue = (myQueue *) q;
	void *rv = queue->back;
	queue->back = queue->array[queue->size - 2];
	queue->size--;
	return rv;
}

int queue_isEmpty(void *q) {
	printf("Created the queue\n");
	myQueue *queue = (myQueue *) q;
	if (queue->size == 0) {
		return 1;
	}
	else {
		return 0;
	}
}
