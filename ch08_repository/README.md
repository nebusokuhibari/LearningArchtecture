# Repository

サンプルアプリ

![play.gif](./play.gif?raw=true)

コレクションの追加・削除・抽出

# Repositoryパターンとは

DBなどから取得したデータをキャッシュとして残して永続化を隠ぺいするためのデザインパターン。
しかし、今回作ったサンプルのプロジェクトでは説明の簡略化のためDBを使っておらず、疑似的に取ってきたつもりでコードを書いています。

# 備忘録

フローはこんな感じ

1. Repositoryクラスがデータベースから取ってきたデータをキャッシュとして残す（本プロジェクトでは疑似的なコード）
2. ユーザーがUI上を操作する
3. キャッシュを操作するイベントが走って、それをviewに反映する。

# 個人的メモ

少し面白みがない。先にNavigationに関するコードを書いてからのほうがよかったかも
このプロジェクトはあとで作り直すかもしれない