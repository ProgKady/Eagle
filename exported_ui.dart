import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Center(
        Container(
          color: Color(0xFFFFFFFF),
          width: 100.0,
          height: 100.0,
          padding: EdgeInsets.all(8.0),
          child:
            TextButton(
              onPressed: () {},
              style: TextButton.styleFrom(
                backgroundColor: Color(0xFF2196F3),
              ),
              child: Text('Click Mefgfg'),
            ),
        ),
        ),
      ),
    );
  }
}
