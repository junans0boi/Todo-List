// src/screens/CalendarScreen.js
import React from 'react';
import { View, Text, StyleSheet } from 'react-native';
import Calendar from '../components/Calendar';

export default function CalendarScreen() {
  return (
    <View style={styles.container}>
      {/* 공통 헤더 (웹에서는 사이드바가 대신 헤더 역할) */}
      

      {/* 본문 */}
      <View style={styles.body}>
        <Calendar />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: '#fff' },
  header:    { height: 56, paddingHorizontal: 16, justifyContent: 'center', borderBottomWidth: 1, borderColor: '#eee' },
  title:     { fontSize: 20, fontWeight: 'bold' },
  body:      { flex: 1, padding: 16 },
});