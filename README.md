# LeetCode Problem Solving — DSA Explorer

An interactive, responsive single-page web dashboard to search, filter, and explore my LeetCode Data Structures & Algorithms solutions. Built with HTML5, Tailwind CSS, and Vanilla JavaScript.

## 🚀 Key Features

- **⚡ 100% Dynamic Auto-Sync**: The dashboard dynamically fetches the repository tree from GitHub via the Git Trees API. Whenever you push a new solution folder (e.g. `0075-sort-colors/`) to [`rohitkr7/leetcode-problem-solving`](https://github.com/rohitkr7/leetcode-problem-solving), it immediately appears on the viewer without needing to edit any configuration!
- **📋 High-Density List / Table View**: Clean, compact table layout displaying problem numbers, titles, colored difficulty badges, topic tags, and action buttons.
- **🔍 Real-Time Search & Multi-Criteria Filtering**: Filter instantly by problem title, number, difficulty (`Easy`, `Medium`, `Hard`), and topics/patterns (`Two Pointers`, `Trees`, `Dynamic Programming`, etc.).
- **💻 Interactive Code & Problem Viewer**: Clicking any row opens a modal that lazily fetches the problem statement (`README.md`) and the solution (`.java`), formatted with Prism.js syntax highlighting and a 1-click "Copy Code" button.
- **💾 Offline Resilience & Speed**: Bundled with a fallback dataset and `localStorage` caching for instant loading and zero rate-limit issues.

## 🛠️ Local Development

Since this project dynamically interacts with APIs and bundled assets:

```bash
python3 -m http.server 8000
```
Then open `http://localhost:8000/` in your browser.

## 🌐 Deployment to GitHub Pages

1. Commit and push the files to your `leetcode-viewer` repository.
2. In your repository on GitHub, go to **Settings > Pages**.
3. Under **Build and deployment**, select **Deploy from a branch** (choose `main` branch and `/ (root)` folder).
4. Your dashboard will be live at `https://rohitkr7.github.io/leetcode-viewer/`!

