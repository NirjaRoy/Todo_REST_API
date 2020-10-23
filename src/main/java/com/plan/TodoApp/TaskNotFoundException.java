package com.plan.TodoApp;


	public class TaskNotFoundException extends RuntimeException {

		public TaskNotFoundException() {
		}

		public TaskNotFoundException(String arg0) {
			super(arg0);
		}

		public TaskNotFoundException(Throwable arg0) {
			super(arg0);
		}

		public TaskNotFoundException(String arg0, Throwable arg1) {
			super(arg0, arg1);
		}

		public TaskNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
			super(arg0, arg1, arg2, arg3);
		}

	}

