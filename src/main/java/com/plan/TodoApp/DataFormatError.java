package com.plan.TodoApp;


	public class DataFormatError extends RuntimeException{

		public DataFormatError() {
			
		}
		public DataFormatError(String string) {
			super(string);
		}

		public DataFormatError(Throwable arg0) {
			super(arg0);
		}

		public DataFormatError(String arg0, Throwable arg1) {
			super(arg0, arg1);
		}

		public DataFormatError(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
			super(arg0, arg1, arg2, arg3);
		}
	}


