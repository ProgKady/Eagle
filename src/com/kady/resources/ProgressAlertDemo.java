//
//Alert alert = new Alert(Alert.AlertType.NONE);
//alert.setTitle("Creating APK, Please wait ...");
//String contentText = "Congratulations\n" +
//        "Task maybe takes 1 minute, you will find \"" + apknam + ".apk\" on your desktop after Finishing.\n" +
//        "Support Eagle and Kadysoft on Facebook.\n\nMade with Love by Kadysoft.";
//Label statusLabel = new Label(contentText);
//ProgressBar progressBar = new ProgressBar(0);
//progressBar.setPrefWidth(300);
//VBox content = new VBox(10, statusLabel, progressBar);
//alert.getDialogPane().setContent(content);
//alert.setGraphic(imgview);
//alert.setResizable(false);
//alert.getDialogPane().getStylesheets().add(
//getClass().getResource("nord-dark.css").toExternalForm());
//alert.show();
//
//
//
//
//Task<Void> task = new Task<>() {
//    @Override
//    protected Void call() throws Exception {
//        double progress = 0.0;
//        Random random = new Random();
//        // Start a thread to simulate random progress
//        Thread progressThread = new Thread(() -> {
//            while (progressBar.getProgress() < 0.95) {
//                try {
//                    Thread.sleep(300 + random.nextInt(300));
//                    double current = progressBar.getProgress();
//                    double next = Math.min(current + 0.03 + random.nextDouble() * 0.05, 0.95);
//                    final double finalProgress = next;
//                    Platform.runLater(() -> progressBar.setProgress(finalProgress));
//                } catch (InterruptedException ignored) {
//                }
//            }
//        });
//        progressThread.setDaemon(true);
//        progressThread.start();
//
//
//
//
//
//
//        // Your actual work
//       
//
//
//
//
//
//
//
//
//        // Wait just to simulate work (optional)
//        Thread.sleep(1000);
//        // Set final progress to 100%
//        Platform.runLater(() -> progressBar.setProgress(1.0));
//        return null;
//    }
//    @Override
//    protected void succeeded() {
//        super.succeeded();
//        alert.close();
//        Platform.runLater(() -> {
//            Alert done = new Alert(Alert.AlertType.INFORMATION);
//            done.setTitle("Done");
//            done.setContentText("APK created successfully on your desktop!");
//            done.showAndWait();
//        });
//    }
//};
//new Thread(task).start();
